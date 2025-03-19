<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f5f5f5;
        }
        .dashboard-container {
            max-width: 1200px;
            margin: auto;
            margin-top: 20px;
            padding: 20px;
        }
        .card-custom {
            border-radius: 15px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            background: white;
        }
        .btn-custom {
            border-radius: 10px;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container dashboard-container">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="text-primary">Payments Dashboard</h2>
            <a href="Logout.java" class="btn btn-danger btn-custom">Logout</a>
        </div>
        <%String fname = (String)session.getAttribute("fName");
          String lname = (String)session.getAttribute("lName");
          String phno = (String)session.getAttribute("phno");
  		  String email = (String)session.getAttribute("email");
  		  String address = (String)session.getAttribute("address"); 
        %>
        <div class="row">
        	<div class="col-md-4 card-custom border p-3">
                <h6>Profile</h6>
                <p><strong>First Name:</strong><%=fname %></p>
                <p><strong>Last Name:</strong><%=lname %></p>
                <p><strong>Phone Number:</strong><%=phno %></p>
                <p><strong>Email:</strong><%=email %></p>
                <p><strong>Address:</strong><%=address %></p>
                <a href="editBankAcct.jsp" class="btn btn-success btn-sm btn-custom">Edit</a>
            </div>
            <div class="col-md-6 card-custom">
                <h5>Primary Bank Account</h5>
                <p><strong>Account No:</strong> 1234</p>
                <p><strong>Balance:</strong> ₹90.00</p>
                <p><strong>Wallet:</strong> ₹77.00 <a href="#" class="text-primary">[+]</a></p>
                <a href="sendMoney.jsp" class="btn btn-primary btn-custom">Send Money</a>
            </div>
        </div>
        
        <div class="row mt-4">
            <div class="col-md-4 card-custom border p-3">
                <h6>Bank Account 1</h6>
                <p><strong>Account No:</strong> 1234</p>
                <p><strong>Balance:</strong> ₹XXXX.XX</p>
                <p><strong>IFSC Code:</strong> XXXXXXXX</p>
                <a href="editBankAcct.jsp" class="btn btn-success btn-sm btn-custom">Edit</a>
            </div>
            <div class="col-md-4 card-custom border p-3 text-center">
                <a href="addBankAcct.jsp" class="btn btn-outline-primary btn-custom w-100">+ Add Account</a>
            </div>
        </div>
        
        <div class="row mt-4 card-custom">
            <h6>Recent Transactions</h6>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">₹1000 sent to chanakya</li>
                <li class="list-group-item">₹1300 received from ashit</li>
                <li class="list-group-item">₹120 received from 34897</li>
            </ul>
            <a href="stmtRequest.jsp" class="btn btn-outline-secondary btn-custom mt-3">View Detailed Statement</a>
        </div>
    </div>
</body>
</html>