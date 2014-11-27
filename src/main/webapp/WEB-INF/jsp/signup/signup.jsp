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
  <link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/cover.css">
  
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
        </div><!-- masthead clearfix close -->

        <div class="inner cover">
          <h1 class="cover-heading">Sign Up</h1>
          <form class="form-signup" method="post" role="form" action="${pageContext.request.contextPath}/signup/save">
            <label for="inputUsername" class="sr-only">Username</label>
            <input title="owner.login" type="text" id="inputUsername" class="form-control input-custom" placeholder="Username" required autofocus> 
            
            <label for="inputPassword" class="sr-only">Password</label> 
            <input title="owner.password" type="password" id="inputPassword" class="form-control input-custom" placeholder="Password" required> 
            
            <label for="inputAccountNumber" class="sr-only">account number</label> 
            <input title="account.number" type="text" id="inputAccountNumber" class="form-control input-custom" placeholder="Account number" required> 
            
            <label for="inputBalance" class="sr-only">initial balance</label>
            <input title="account.balance" type="text" id="inputBalance" class="form-control input-custom" placeholder="Initial balance" required>

            <button class="btn btn-lg btn-primary btn-block btn-signup" type="submit">Sign up</button>
          </form>
        </div><!-- inner cover close -->

      </div><!-- cover-container close -->
    </div><!-- site-wrapper-inner close -->
  </div><!-- site-wrapper close -->

  <!-- JavaScripts -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  <script>
  // VALIDATION INIT
/* 			$('.btn-signup').on("click", function(event) {
              event.preventDefault();
				console.log("Working");

			}) */
		</script>
</body>
</html>