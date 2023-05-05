package hr.ja.weboo.layout;

import hr.ja.weboo.lib.MyUtil;
import hr.ja.weboo.lib.Widget;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Adminlte4Layout extends Widget {

    private HeadLayout header;
    private SidenavLayout sidenav;
    private TopbarLayout topBar;
    private FooterLayout footer;

    private String lang = "en";

    @Override
    public String toHtml() {
        //const title = 'AdminLTE 4 | Fixed Sidebar'
        //const path = '../../../dist'
        //const mainPage = 'layout'
        //const page = 'fixed-sidebar'
        String h = """
              <!DOCTYPE html>
              <html lang="${lang}">
                <head>
                  ${header}
                </head>
                <body class="layout-fixed sidebar-expand-lg bg-body-tertiary">
                  <div class="app-wrapper">
                    ${topBar}
                    <Sidenav path={path} mainPage={mainPage} page={page} />
                    
                    ${sidenav}
                            
                    <!-- Main content -->
                    <main class="app-main">
                      <div class="app-content-header">
                        <div class="container-fluid">
                        
                          <div class="row">
                            <div class="col-sm-6">
                              <h3 class="mb-0">Fixed Layout</h3>
                            </div>
                            <div class="col-sm-6">
                              <ol class="breadcrumb float-sm-end">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Fixed Layout</li>
                              </ol>
                            </div>
                          </div>
                          
                        </div>
                      </div>
                      <!-- Main content -->
                      <div class="app-content">
                        <div class="container-fluid">
                          <div class="row">
                            <div class="col-12">
                              <!-- Default box -->
                              <div class="card">
                                <div class="card-header">
                                  <h3 class="card-title">Title</h3>
                            
                                  <div class="card-tools">
                                    <button type="button" class="btn btn-tool" data-lte-toggle="card-collapse" title="Collapse">
                                      <i class="fa-solid fa-minus"></i>
                                    </button>
                                    <button type="button" class="btn btn-tool" data-lte-dismiss="card-remove" title="Remove">
                                      <i class="fa-solid fa-times"></i>
                                    </button>
                                  </div>
                                </div>
                                <div class="card-body">
                                  Start creating your amazing application!
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                  Footer
                                </div>
                                <!-- /.card-footer-->
                              </div>
                              <!-- /.card -->
                            </div>
                          </div>
                          <!-- /.row -->
                        </div><!-- /.container-fluid -->
                      </div>
                      <!-- /.content -->
                    </main>
                    <!-- /.app-content -->
                            
                    <Footer />
                  </div>
                  <!--  ./app-wrapper -->
                            
                  <Scripts path={path} />
                </body>
              </html>
              """;
        return MyUtil.quteThis(h, this).render();
    }
}
