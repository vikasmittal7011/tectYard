<%
    String message = (String) session.getAttribute("message");
    if(message != null){
%>

<div class="alert alert-dismissible fade show mt-3 fs-4" role="alert">
  <strong><%= message %></strong>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<%
        session.removeAttribute("message");
        }
%>