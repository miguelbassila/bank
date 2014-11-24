<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Our Bank Website">
  <meta name="author" content="Miguel Bassila">

  <title>Our Bank - Sign Up</title>

  <!-- CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cover.css">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body>
  <div class="site-wrapper">
    <div class="site-wrapper-inner">
      <div class="cover-container">
        
        <div class="masthead clearfix">
          <div class="inner">
            <h3 class="masthead-brand">Our Bank</h3>
          </div>
        </div> <!-- masthead clearfix close -->
        
        <div class="inner cover">
          <h1 class="cover-heading">Sign Up</h1>
          
          <label for="inputEmail" class="sr-only">Username</label>
          <input type="text" id="inputEmail" class="form-control" placeholder="Username" required autofocus>
          
          <label for="inputPassword" class="sr-only">password</label>
          <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
          <label for="inputPassword" class="sr-only">account number</label>
          <input type="text" id="inputPassword" class="form-control" placeholder="Account number" required>
          <label for="inputPassword" class="sr-only">initial balance</label>
          <input type="text" id="inputPassword" class="form-control" placeholder="Initial balance" required>
          <button type="submit" class="btn btn-default">Sign in</button>
          
        </div> <!-- inner cover close -->
        
      </div> <!-- cover-container close -->
    </div> <!-- site-wrapper-inner close -->
  </div><!-- site-wrapper close -->

  <!-- JavaScripts -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>