<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ATM </title>
<style> 
body {
 font-family: Arial, sans-serif;
 background-color:gray;
 font-size:16px;
 }
.container {
 margin: 60px auto;
  width: 400px; 
  padding: 20px;
   border: 1px solid #CCC;
  text-align: center;
  background-color: #92a8d1;
  border-radius: 15px;
  }
  button {
  margin: 2px;
  size:8px;
  color:green;
  
  }
  button:hover{
   color:white;
   background-color:red;
  }
  </style>
</head>
<body>

<div class="container">
<h1>ATM Details</h1>

<form action="/deposite" method="post">
  <label for="accountHolder">Account Holder:</label>
  <input type="text" name="accountHolder" required/><br><br>
  
  <label for="amount">Deposit Amount:</label>
  <input type="number" name="amount" required/><br><br>
  <button type="submit">Deposit</button> <br><br>
</form>

<form action="/withdraw" method="post">
  <label for="accountHolder">Account Holder:</label>
  <input type="text" name="accountHolder" required/><br><br>
   
  <label for="amount"> Withdraw Amount:</label>
  <input type="number" name="amount" required/><br><br> 
  <button type="submit">Withdraw</button> <br><br>
</form>

 <form action="/balance" method="get">
 <label for="accountHolder">Account Holder:</label> 
 <input type="text" name="accountHolder" required/><br><br>
 
 <button type="submit">Check Balance</button> <br><br>
  </form>
  
 <form action="/transactions" method="get"> 
 <label for="accountHolder">Account Holder:</label> 
 <input type="text" name="accountHolder" required/><br><br>
 <button type="submit">Transaction History</button> <br><br>
   </form>
   
   
   <p>${message}</p>
   <p>Balance:${balance}</p>
   <p>Transaction:${transaction}</p>
   

</div>

</body>
</html>