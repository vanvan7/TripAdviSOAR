# TripAdviSOAR

Our new Repository to work on it

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html">
    <!-- <example> represent component tags. They are used to display or accept data from the user -->
    <h:head>
        <title>TripAdviSOAR</title><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></link>
        <meta charset="utf-8"></meta>
        <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"></link>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <style>
        .fakeimg {
          height: 200px;
          background: #aaa;
        }
        </style>
    </h:head>
    <h:body>
        <!-- represent the user input components -->
        <div class="jumbotron text-center" style="margin-bottom:0">

        <h1>Welcome to TripAdviSOAR</h1>
        <p>Resize this responsive page to see the effect!</p> 
        </div>

        <nav class="navbar navbar-expand-lg bg-dark navbar-dark x-large">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
          <ul class="navbar-nav">
            <li class="nav-item" >
                <h:link class="nav-link" value="Login as a User" outcome="LoginPage.xhtml?faces-redirect=true" />
            </li>
            <li class="nav-item">
                <h:link  class="nav-link" value="Login as a Restaurant" outcome="LoginPage.xhtml?faces-redirect=true" />
            </li>
            <li class="nav-item">
                <h:link class="nav-link" value="Create a Customer account" outcome="CreateUser.xhtml?faces-redirect=true" />
            </li>    
            <li class="nav-item">
                <h:link class="nav-link" value="Create a Restaurant account" outcome="CreateRestaurant.xhtml?faces-redirect=true" />
            </li>    
            <li class="nav-item">
                <h:link class="nav-link" value="Search for a Restaurant" outcome="SearchRestaurant.xhtml?faces-redirect=true" />
            </li>   
            <li class="nav-item">
                <h:link class="nav-link" value="Show all restaurants" outcome="/MainPage/SeeRestaurant.xhtml?faces-redirect=true" />
            </li> 
          </ul>
        </div>  
        </nav>
        
        <div class="container" style="margin-top:30px">
        <div class="row">
        <div class="col-sm-4">
            <h2>See Restaurants</h2>
            <h5></h5>
        <div class="fakeimg">Fake Image</div>
            <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
        </div>    
        <div class="col-sm-8">
            <h2>Find Restaurant</h2>
        <div class="fakeimg">Fake Image</div>
            <p>Some text..</p>
            <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
        </div>  
        </div>
        </div>
        
    </h:body>
</html>
