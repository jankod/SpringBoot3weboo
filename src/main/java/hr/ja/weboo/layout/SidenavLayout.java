package hr.ja.weboo.layout;

import hr.ja.weboo.lib.Widget;

public class SidenavLayout extends Widget {
    @Override
    public String toHtml() {
//const { path, mainPage, page } = Astro.props
//const htmlPath = convertPathToHtml(path)
        String html = """
              <!-- Sidebar Container -->
              <aside class="app-sidebar bg-body-secondary shadow" data-bs-theme="dark">
                <div class="sidebar-brand">
                  <a href={htmlPath + '/index.html'} class="brand-link">
                    <img src={path + '/assets/img/AdminLTELogo.png'} alt="AdminLTE Logo" class="brand-image opacity-75 shadow">
                    <span class="brand-text fw-light">AdminLTE 4</span>
                  </a>
                </div>
                <!-- Sidebar -->
                <div class="sidebar-wrapper">
                  <nav class="mt-2">
                    <!-- Sidebar Menu -->
                    <ul class="nav sidebar-menu flex-column" data-lte-toggle="treeview" role="menu" data-accordion="false">
                      <li class:list={['nav-item', mainPage === 'dashboard' && 'menu-open']}>
                        <a href="javascript:;" class:list={['nav-link', mainPage === 'dashboard' && 'active']}>
                          <i class="nav-icon fa-solid fa-gauge-high"></i>
                          <p>
                            Dashboard
                            <i class="nav-arrow fa-solid fa-angle-right"></i>
                          </p>
                        </a>
                        <ul class="nav nav-treeview">
                          <li class="nav-item">
                            <a href={htmlPath + '/index.html'} class:list={['nav-link', page === 'index' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Dashboard v1</p>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a href={htmlPath + '/index2.html'} class:list={['nav-link', page === 'index2' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Dashboard v2</p>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a href={htmlPath + '/index3.html'} class:list={['nav-link', page === 'index3' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Dashboard v3</p>
                            </a>
                          </li>
                        </ul>
                      </li>
                      <li class:list={['nav-item', mainPage === 'widgets' && 'menu-open']}>
                        <a href="javascript:;" class:list={['nav-link', mainPage === 'widgets' && 'active']}>
                          <i class="nav-icon fa-solid fa-box-open"></i>
                          <p>
                            Widgets
                            <i class="nav-arrow fa-solid fa-angle-right"></i>
                          </p>
                        </a>
                        <ul class="nav nav-treeview">
                          <li class="nav-item">
                            <a href={htmlPath + '/widgets/small-box.html'} class:list={['nav-link', page === 'small-box' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Small Box</p>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a href={htmlPath + '/widgets/info-box.html'} class:list={['nav-link', page === 'info-box' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>info Box</p>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a href={htmlPath + '/widgets/cards.html'} class:list={['nav-link', page === 'cards' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Cards</p>
                            </a>
                          </li>
                        </ul>
                      </li>
                            
                      <li class:list={['nav-item', mainPage === 'layout' && 'menu-open']}>
                        <a href="javascript:;" class:list={['nav-link', mainPage === 'layout' && 'active']}>
                          <i class="nav-icon fa-solid fa-copy"></i>
                          <p>
                            Layout Options
                            <span class="nav-badge badge text-bg-secondary opacity-75 me-3">6</span>
                            <i class="nav-arrow fa-solid fa-angle-right"></i>
                          </p>
                        </a>
                        <ul class="nav nav-treeview">
                          <li class="nav-item">
                            <a href={htmlPath + '/layout/unfixed-sidebar.html'} class:list={['nav-link', page === 'unfixed-sidebar' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Unfixed Sidebar</p>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a href={htmlPath + '/layout/fixed-sidebar.html'} class:list={['nav-link', page === 'fixed-sidebar' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Fixed Sidebar</p>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a href={htmlPath + '/layout/sidebar-mini.html'} class:list={['nav-link', page === 'sidebar-mini' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Sidebar Mini</p>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a href={htmlPath + '/layout/layout-rtl.html'} class:list={['nav-link', page === 'layout-rtl' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Layout RTL</p>
                            </a>
                          </li>
                        </ul>
                      </li>
                      <li class:list={['nav-item', mainPage === 'ui-elements' && 'menu-open']}>
                        <a href="javascript:;" class:list={['nav-link', mainPage === 'ui-elements' && 'active']}>
                          <i class="nav-icon fa-solid fa-tree"></i>
                          <p>
                            UI Elements
                            <i class="nav-arrow fa-solid fa-angle-right"></i>
                          </p>
                        </a>
                        <ul class="nav nav-treeview">
                          <li class="nav-item">
                            <a href={htmlPath + '/UI/timeline.html'} class:list={['nav-link', page === 'timeline' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Timeline</p>
                            </a>
                          </li>
                        </ul>
                      </li>
                      <li class:list={['nav-item', mainPage === 'forms' && 'menu-open']}>
                        <a href="javascript:;" class:list={['nav-link', mainPage === 'forms' && 'active']}>
                          <i class="nav-icon fa-solid fa-pen-to-square"></i>
                          <p>
                            Forms
                            <i class="nav-arrow fa-solid fa-angle-right"></i>
                          </p>
                        </a>
                        <ul class="nav nav-treeview">
                          <li class="nav-item">
                            <a href={htmlPath + '/forms/general.html'} class:list={['nav-link', page === 'general' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>General Elements</p>
                            </a>
                          </li>
                        </ul>
                      </li>
                      <li class:list={['nav-item', mainPage === 'tables' && 'menu-open']}>
                        <a href="javascript:;" class:list={['nav-link', mainPage === 'tables' && 'active']}>
                          <i class="nav-icon fa-solid fa-table"></i>
                          <p>
                            Tables
                            <i class="nav-arrow fa-solid fa-angle-right"></i>
                          </p>
                        </a>
                        <ul class="nav nav-treeview">
                          <li class="nav-item">
                            <a href={htmlPath + '/tables/simple.html'} class:list={['nav-link', page === 'simple' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Simple Tables</p>
                            </a>
                          </li>
                        </ul>
                      </li>
                            
                      <li class="nav-header">EXAMPLES</li>
                      <li class="nav-item">
                        <a href="javascript:;" class="nav-link">
                          <i class="nav-icon fa-solid fa-arrow-right-to-bracket"></i>
                          <p>
                            Login & Register
                            <i class="nav-arrow fa-solid fa-angle-right"></i>
                          </p>
                        </a>
                        <ul class="nav nav-treeview">
                          <li class="nav-item">
                            <a href={htmlPath + '/examples/login.html'} class="nav-link ">
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Login v1</p>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a href={htmlPath + '/examples/register.html'} class="nav-link ">
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Register v1</p>
                            </a>
                          </li>
                        </ul>
                      </li>
                            
                      <li class="nav-header">DOCUMENTATIONS</li>
                      <li class="nav-item">
                        <a href={htmlPath + '/docs/index.html'} class:list={['nav-link', page === 'introduction' && 'active']}>
                          <i class="nav-icon fa-solid fa-download"></i>
                          <p>Installation</p>
                        </a>
                      </li>
                      <li class="nav-item">
                        <a href={htmlPath + '/docs/color-mode.html'} class:list={['nav-link', page === 'color-mode' && 'active']}>
                          <i class="nav-icon fa-solid fa-star-half-stroke"></i>
                          <p>Color Mode</p>
                        </a>
                      </li>
                      <li class:list={['nav-item', mainPage === 'components' && 'menu-open']}>
                        <a href="javascript:;" class:list={['nav-link', mainPage === 'components' && 'active']}>
                          <i class="nav-icon fa-solid fa-swatchbook"></i>
                          <p>
                            Components
                            <i class="nav-arrow fa-solid fa-angle-right"></i>
                          </p>
                        </a>
                        <ul class="nav nav-treeview">
                          <li class="nav-item">
                            <a href={htmlPath + '/docs/components/main-header.html'} class:list={['nav-link', page === 'main-header' && 'active']}>
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Main Header</p>
                            </a>
                          </li>
                        </ul>
                      </li>
                      <li class="nav-item">
                        <a href={htmlPath + '/docs/browser-support.html'} class:list={['nav-link', page === 'browser-support' && 'active']}>
                          <i class="nav-icon fa-solid fa-edge"></i>
                          <p>Browser Support</p>
                        </a>
                      </li>
                            
                      <li class="nav-header">MULTI LEVEL EXAMPLE</li>
                      <li class="nav-item">
                        <a href="javascript:;" class="nav-link">
                          <i class="nav-icon fa-solid fa-circle"></i>
                          <p>Level 1</p>
                        </a>
                      </li>
                      <li class="nav-item">
                        <a href="javascript:;" class="nav-link">
                          <i class="nav-icon fa-solid fa-circle"></i>
                          <p>
                            Level 1
                            <i class="nav-arrow fa-solid fa-angle-right"></i>
                          </p>
                        </a>
                        <ul class="nav nav-treeview">
                          <li class="nav-item">
                            <a href="javascript:;" class="nav-link">
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Level 2</p>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a href="javascript:;" class="nav-link">
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>
                                Level 2
                                <i class="nav-arrow fa-solid fa-angle-right"></i>
                              </p>
                            </a>
                            <ul class="nav nav-treeview">
                              <li class="nav-item">
                                <a href="javascript:;" class="nav-link">
                                  <i class="nav-icon fa-regular fa-dot-circle"></i>
                                  <p>Level 3</p>
                                </a>
                              </li>
                              <li class="nav-item">
                                <a href="javascript:;" class="nav-link">
                                  <i class="nav-icon fa-regular fa-dot-circle"></i>
                                  <p>Level 3</p>
                                </a>
                              </li>
                              <li class="nav-item">
                                <a href="javascript:;" class="nav-link">
                                  <i class="nav-icon fa-regular fa-dot-circle"></i>
                                  <p>Level 3</p>
                                </a>
                              </li>
                            </ul>
                          </li>
                          <li class="nav-item">
                            <a href="javascript:;" class="nav-link">
                              <i class="nav-icon fa-regular fa-circle"></i>
                              <p>Level 2</p>
                            </a>
                          </li>
                        </ul>
                      </li>
                      <li class="nav-item">
                        <a href="javascript:;" class="nav-link">
                          <i class="nav-icon fa-solid fa-circle"></i>
                          <p>Level 1</p>
                        </a>
                      </li>
                      <li class="nav-header">LABELS</li>
                      <li class="nav-item">
                        <a href="javascript:;" class="nav-link">
                          <i class="nav-icon fa-regular fa-circle text-danger"></i>
                          <p class="text">Important</p>
                        </a>
                      </li>
                      <li class="nav-item">
                        <a href="javascript:;" class="nav-link">
                          <i class="nav-icon fa-regular fa-circle text-warning"></i>
                          <p>Warning</p>
                        </a>
                      </li>
                      <li class="nav-item">
                        <a href="javascript:;" class="nav-link">
                          <i class="nav-icon fa-regular fa-circle text-info"></i>
                          <p>Informational</p>
                        </a>
                      </li>
                    </ul>
                  </nav>
                </div>
                <!-- /.sidebar -->
              </aside>                                                        
              """;
        return null;
    }
}
