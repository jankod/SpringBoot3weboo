const Weboo = {
    commands: {
        RedirectJsCommand: function (url) {
            window.location.href = url;
        }
    }
}


Weboo.form = function (formEl, funcValidated) {
    $(formEl).on('submit', function (event) {
        event.preventDefault();
        let form = $(this);
        let actionUrl = form.attr('action');
        $.ajax({
            method: "POST",
            url: actionUrl,
            data: form.serialize(),
            headers: {'weboo-form-id': form.attr('id')}
        })
            //$.post(actionUrl, form.serialize())
            .done(function (res) {
                $('.invalid-feedback', form).remove();
                $('.is-invalid', form).removeClass('is-invalid');
                //form.removeClass("was-validated");
                if (!res.ok) {
                    if (res.errors)
                        res.errors.forEach((err) => {
                            //$(form).addClass('needs-validation');
                            //   form.addClass("was-validated");
                            $(`${formEl} [name='${err.field}']`).addClass('is-invalid')
                                .after(`<div class="invalid-feedback">
                              ${err.message}
                        </div>`);
                            console.log(`Error field '${err.field}' message: ${err.message}`);
                        });
                } else {

                    $.each(res.jsCommands, function (num, command) {
                        // console.log("command ", command);
                        if (typeof Weboo.commands[command.name] === "function") {
                            Weboo.commands[command.name](...command.params);
                            //console.log("Nasao sam function command")
                        } else {
                            console.warn(`Not find command ${command.name}`)
                        }
                    });

                    console.log("Sve ok", res);
                    if (res.actionRedirectUrl) {
                        window.location.href = res.actionRedirectUrl;
                        return;
                    }

                    if (res.commands) {
                        if (res.commands.SHOW_MESSAGE) {
                            Swal.fire(
                                'Message',
                                res.commands.SHOW_MESSAGE,
                                'success'
                            )
                        }
                        console.log("Commands ", res.commands);
                    }
                }
                if (funcValidated) {
                    funcValidated(res);
                }
            }).fail(function (err) {
            console.log("error ", err.responseJSON)
            Swal.fire({
                icon: 'error',
                title: 'Oops... error',
                html: err.responseJSON.message
            });
        })
    });
}
$(function () {
    Weboo.form("form")
});