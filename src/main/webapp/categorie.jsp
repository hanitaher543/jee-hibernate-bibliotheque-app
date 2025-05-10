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
       <a class="btn btn-primary" href="#"><i class="fas fa-sign-in-alt"></i><c:out value ="${sessionScope.user.nom}"></c:out>(Deconnexion)</a>
    </div>
    
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
      <li class="nav-item mb-2">
            <a class="nav-link active" href="espace_user.jsp"><i class="fas fa-home me-2"></i>Dashboard</a>
          </li>
          <li class="nav-item mb-2">
            <a class="nav-link" href="PreCat"><i class="fas fa-book me-2"></i>Livres disponibles</a>
          </li>
          <li class="nav-item mb-2">
            <a class="nav-link" href="PreEmprunt"><i class="fas fa-list me-2"></i>Mes emprunts</a>
          </li>
        
      </nav>

      <!-- Main Content -->
      <main class="col-md-10 ms-sm-auto content">
        
		<h2 class="mb-4 text-center text-primary">Les cat�gories des Livres</h2>

			<div class="row g-4">
			 <c:forEach items="${liste}" var="c"> 
			 
				  <div class="col-sm-6 col-lg-4">
					<div class="card category-card h-100 border-0 shadow-sm">
					  <div class="card-body text-center">
						<i class="text-primary mb-3"></i>
						<h5 class="card-title">${c.titre}</h5>
						<a href="PreLivre?id=${c.id}" class="btn btn-outline-primary mt-2">Voir les livres</a>
					  </div>
					</div>
				  </div>
				 </c:forEach>

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
    