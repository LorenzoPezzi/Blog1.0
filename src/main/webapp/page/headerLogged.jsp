<header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
              <a class="navbar-brand" href="/Index">BLOG</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="?cmd=HOME">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Page2</a>
                  </li>
                </ul>
				<form class="d-flex m-auto">
                  <input class="form-control m-auto" id="search" type="search" placeholder="Search" aria-label="Search"
                   oninput="searchRequest()" onfocusout="hideBox()" onfocusin="searchRequest()">
                  <div id="searchBox" style="position:absolute; display:none; margin-top:40px; width:205px; z-index:100;" class="bg-light text-dark"></div>
                  <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                  <p class="me-2 text-dark">Hello, <a class="text-decoration-none" href="?cmd=PROFILE&nick=<%= user.getNickname() %>"><%= user.getNickname() %></a></p>
                  <a href="?cmd=OPTION" class="text-dark"><i class="p-2 fas fa-cog fa-2x"></i></a>
                  <a href="?cmd=LOGOUT" class="btn btn-outline-danger">LOGOUT</a>

              </div>
            </div>
          </nav>
      </header>