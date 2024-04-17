@param hr.ja.weboo.demo.JtePage page


Name: ${page.getName()} age: ${page.toString()} sss <br>


@template.form_input( name="name", value=  "dsdsfds" )

@template.form_input(name = "eef", value = "sdfdsfs")


@for(var l : page.getList())
    <p>${l.toUpperCase()}</p>
@endfor
<br>
@for(var ff : gg.jte.support.ForSupport.of( page.getList( ) ) )
    <p> ${ff.getIndex()} </p>
@endfor

