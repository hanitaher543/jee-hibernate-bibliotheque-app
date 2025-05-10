<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ page isELIgnored="false" %>
    
    
    
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Gestion Biblioth�que</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
  <style>
    body {
      font-family: 'Segoe UI', sans-serif;
      background-color: #f8f9fa;
    }
    .sidebar {
      height: 100vh;
      background-color: #343a40;
    }
    .sidebar .nav-link {
      color: #ffffff;
    }
    .sidebar .nav-link.active {
      background-color: #0d6efd;
      color: white;
    }
    .sidebar .nav-link:hover {
      background-color: #495057;
    }
    .content {
      padding: 2rem;
    }
    .card-hover:hover {
      transform: scale(1.02);
      transition: all 0.2s;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    }
  </style>
</head>
<body>

 <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm px-4">
    <a class="navbar-brand fw-bold text-primary" href="#"><i class="fas fa-book me-2"></i>Biblioth�que ESSAT</a>
    <div class="ms-auto">
       <a class="btn btn-primary" href="Dec"><i class="fas fa-sign-in-alt"></i>
      <c:out value ="${sessionScope.user.nom}"></c:out>(Deconnexion)
       </a>
    </div>
  </nav>

  <div class="container-fluid">
    <div class="row">
      <!-- Sidebar -->
      <nav class="col-md-2 d-none d-md-block sidebar p-3">
        <ul class="nav flex-column">
          <li class="nav-item mb-2">
            <a class="nav-link active" href="espace_user.jsp"><i class="fas fa-home me-2"></i>Dashboard</a>
          </li>
          <li class="nav-item mb-2">
            <a class="nav-link" href="PreCat"><i class="fas fa-book me-2"></i>Livres disponibles</a>
          </li>
          <li class="nav-item mb-2">
            <a class="nav-link" href="PreEmprunt"><i class="fas fa-list me-2"></i>Mes emprunts</a>
          </li>
         
        </ul>
      </nav>

      <!-- Main Content -->
      <main class="col-md-10 ms-sm-auto content">        

			<div class="row g-4">			 
			
				  <div class="col-md-6 col-lg-4 mb-4">
					<div class="card card-hover border-0 shadow-sm">
					  <div class="card-body">
						<h5 class="card-title"><i class="fas fa-book-open me-2 text-primary"></i>Livres disponibles</h5>
						<p class="card-text">Consulter tous les livres class�s par cat�gorie.</p>
						<a href="PreCat" class="btn btn-outline-primary">Voir</a>
					  </div>
					</div>
				  </div>
				  <div class="col-md-6 col-lg-4 mb-4">
					<div class="card card-hover border-0 shadow-sm">
					  <div class="card-body">
						<h5 class="card-title"><i class="fas fa-history me-2 text-success"></i>Mes emprunts</h5>
						<p class="card-text">Voir la liste des livres d�j� emprunt�s.</p>
						<a href="PreEmprunt" class="btn btn-outline-success">Voir</a>
					  </div>
					</div>
				  </div>
				 
      
	  
			
			
			
			
			</div>	
				
		
		
      </main>
    </div>
  </div>

  <!-- Footer -->
  <footer class="bg-light text-center text-muted py-3 mt-4 border-top">
    &copy; 2025 - Application Biblioth�que ESSAT
  </footer>

  <!-- Bootstrap & Icons -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
    