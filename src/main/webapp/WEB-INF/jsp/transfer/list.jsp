<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Our Bank Website">
  <meta name="author" content="Miguel Bassila">

  <title>Our Bank - Dashboard</title>

  <!-- CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cover.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body>
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Our Bank</a>
      </div><!-- navbar-header close -->
      <div id="navbar" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li><a href="${linkTo[TransferController].add}"><i class="glyphicon glyphicon-plus"></i></a></li>
        </ul>
        <div class="navbar-form navbar-right">
          <div class="dropdown">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
              Dropdown
              <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
              <li role="presentation"><a role="menuitem" tabindex="-1" href="${linkTo[LoginController].logout}">Logout</a></li>
            </ul>
          </div>
        </div>
      </div><!-- navbar close -->
     </div><!-- container close -->
  </nav>

  <div class="container">
  
    <div class="starter-template">
      <h1>All transfers</h1>
      <table class="table table-hover">
        <thead>
          <tr>To account</tr>
          <tr>Amount</tr>
          <tr>Date</tr>
          <tr>Fee</tr>
        </thead>
        <tbody>
          
        </tbody>
      </table>
    </div>
  
  </div><!-- container close -->

  <!-- JavaScripts -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>