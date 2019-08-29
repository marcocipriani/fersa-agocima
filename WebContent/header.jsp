<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <title>FERSA</title>
  </head>
  <body>

    <!-- inizio MENU -->
    <header>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
          <a class="navbar-brand" href="#">Menu</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="homepage.html">Logout</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
    <!-- fine MENU -->

    <!-- inizio TESTATA -->
    <div class="jumbotron jumbotron-fluid testata py-4 mb-0" style="background: url(img/testata.jpg);
      -webkit-background-size: cover;
      background-position: center;">
      <div class="container">
        <h1 class="display-4">F.E.R.S.A.</h1>
        <p class="lead">Filter Evaluation Renting System Application</p>
        <hr class="my-4">
        <p>Leggi il regolamento per il sistema di valutazione</p>

        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong" style="text-transform: uppercase;">
          Regolamento
        </button>

        <!-- Modal -->
        <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle" style="text-transform: uppercase;">Regolamento</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <p>Benvenuto nel sistema FERSA, lo strumento che ti consentirà di scrivere, modificare, eliminare e visualizzare le recensioni della piattaforma</p>
                <p>Prima di qualsiasi azione (salvo la visualizzazione), controlla se sei in linea con i seguenti requisiti:</p>
                <ul>
                  <li>Non devi essere bannato</li>
                  <li>Devi essere registrato ed autenticato</li>
                  <li>Il contratto deve essere terminato</li>
                </ul>
                <p>La visualizzazione è aperta a tutti gli utenti (registrati e non).</p>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
    <!-- fine TESTATA -->