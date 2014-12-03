<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Our Bank Website">
  <meta name="author" content="Miguel Bassila">

  <title>Our Bank - Add transfer</title>

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
          <li><a href="#"><i class="glyphicon glyphicon-plus"></i></a></li>
        </ul>
        <div class="navbar-form navbar-right">
          <div class="dropdown">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
              Dropdown
              <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Logout</a></li>
            </ul>
          </div>
        </div>
      </div><!-- navbar close -->
     </div><!-- container close -->
  </nav>

  <div class="container">
  
    <div class="starter-template">
      <h1>New Transfer</h1>
        <div class="inner cover">
    
          <form class="form" method="post" role="form" action="${pageContext.request.contextPath}/signup/save">
            <label for="accountNumber" class="sr-only">Account number</label>
            <input name="owner.login" type="text" id="accountNumber" class="form-control input-custom" placeholder="Account number" required autofocus> 
            
            <label for="amount" class="sr-only">Amount</label> 
            <input name="owner.password" type="text" id="amount" class="form-control input-custom" placeholder="Amount" required> 
            
            <label for="dateSchedule" class="sr-only">Date schedule</label> 
            <input name="owner.account.number" type="text" id="dateSchedule" class="form-control input-custom" placeholder="Date schedule" required> 
            
            <label for="feeType" class="sr-only">Fee type</label>
            <select name="feeType" id="feeType" class="form-control" class="form-control input-custom select-custom" required >
              <option>Fee type</option>
              <option value="A">A</option>
              <option value="B">B</option>
              <option value="C">C</option>
              <option value="D">D</option>
            </select>
            
            <br>

            <button class="btn btn-lg btn-primary btn-block btn-signup" type="submit">Confirm</button>
          </form>
        </div><!-- inner cover close -->
    </div>
  
  </div><!-- container close -->

  <!-- JavaScripts -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.mask.min.js"></script>
  <script>
	jQuery(function($){
	       $("#accountNumber").mask("99999-9");
	       $("#amount").mask("000.000.000.000.000,00");
	});
   </script>
</body>
</html>