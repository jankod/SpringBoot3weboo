```html
<!-- Navbar -->
<nav class="app-header navbar navbar-expand bg-body">
  <div class="container-fluid">
    <!-- Start navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a
          class="nav-link"
          data-lte-toggle="sidebar"
          href="#"
          role="button"><i class="fa-solid fa-bars"></i></a
        >
      </li>
      <li class="nav-item d-none d-md-block">
        <a href="#" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-md-block">
        <a href="#" class="nav-link">Contact</a>
      </li>
    </ul>
    <ul class="navbar-nav ms-auto">
      <li class="nav-item dropdown">
        <button
          class="btn btn-link nav-link py-2 px-0 px-lg-2 dropdown-toggle d-flex align-items-center"
          id="bd-theme"
          type="button"
          aria-expanded="false"
          data-bs-toggle="dropdown"
          data-bs-display="static"
        >
          <span class="theme-icon-active">
            <i class="my-1"></i>
          </span>
        </button>
        <ul
          class="dropdown-menu dropdown-menu-end"
          aria-labelledby="bd-theme"
          style="--bs-dropdown-min-width: 8rem;"
        >
          <li>
            <button
              type="button"
              class="dropdown-item d-flex align-items-center active"
              data-bs-theme-value="light"
            >
              <i class="fa-regular fa-sun me-2"></i>
              Light
              <i class="fa-solid fa-check ms-auto d-none"></i>
            </button>
          </li>
          <li>
            <button
              type="button"
              class="dropdown-item d-flex align-items-center"
              data-bs-theme-value="dark"
            >
              <i class="fa-solid fa-moon me-2"></i>
              Dark
              <i class="fa-solid fa-check ms-auto d-none"></i>
            </button>
          </li>
          <li>
            <button
              type="button"
              class="dropdown-item d-flex align-items-center"
              data-bs-theme-value="auto"
            >
              <i class="fa-solid fa-circle-half-stroke me-2"
              ></i>
              Auto
              <i class="fa-solid fa-check ms-auto d-none"></i>
            </button>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</nav>
```