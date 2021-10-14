<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
<link rel="icon"  type="image/png" sizes="16×16" href='<c:url value="/resources/Image/logo.png"/>'>

<link rel="stylesheet" href='<c:url value="/resources/Styles/dasboard.css"/>'>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
</head>
<body>



	<input type="checkbox"  id="sidebar-toggle">
    <div class="sidebar">
        <div class="slidebar-header">
            <h3 class="brand">
                <!-- <span class="ti-unlink"></span> -->
                <span>easywire</span>
            </h3>

            <label for="sidebar-toggle" class="ti-menu-alt"></label>
        </div>
        <div class="sidebar-menu">
            <ul>
                <li>
                    <a href='<c:url value="/"/>'>
                        <span class="ti-home"></span>
                        <span>Home</span>
                    </a>
                </li>
              
            </ul>

        </div>

    </div>

    <div class="main-content"> 
          
        <div class="product__adds"> 
       
            <div class="product__add">
            
              <span class="message">${mesage}</span>
            
              <form id="from-data" action="update" method="post" >
              
              
                <input type="number" required="required" id="id" name="id"  placeholder="${policy.id }">
                <input type="text" required="required" id="startDate"  readonly="readonly" name="startDate" placeholder="${policy.startDate }">
                <input type="text" required="required" id="expiryDate" readonly="readonly"  name="expiryDate" placeholder="${policy.expiryDate }">
              
                <input type="text" required="required"  id="policyOwner"  readonly="readonly" name="policyOwner"  placeholder="${policy.policyOwner }">
                <input type="text" required="required" id="engineNo"  readonly="readonly" name="engineNo" placeholder="${policy.engineNo }">
                <input type="text" required="required" id="chassisNo" readonly="readonly" name="chassisNo" placeholder="${policy.chassisNo }">
                <input type="text" required="required" id="vehicleNo" readonly="readonly" name="vehicleNo" placeholder="${policy.vehicleNo }">
                
                <select id="billingCurrency" required="required"  name="billingCurrency">
                       <option  value="${policy.billingCurrency}">${policy.billingCurrency}</option>
				
					<option value="VND">Vietnam Dong</option>
					<option value="USD">US Dollar</option>
					<option value="SGD">Singapore Dollar</option>
					
			    </select>
			    
			     <input type="number" required="required" id="sumInsured" name="sumInsured" placeholder="${policy.sumInsured }">
			     <input type="number" required="required" readonly="readonly" id="rate" name="rate" placeholder="${policy.rate }">
			     <input type="number" required="required" readonly="readonly" id="annualPremium" name="annualPremium" placeholder="${policy.annualPremium }">
			     <input type="number" required="required" readonly="readonly" id="postedPremium" name="postedPremium" placeholder="${policy.postedPremium }">
			    
			      
	            
			            <button class="dash__btn--update">Refresh</button> 
			            
	
	             
               </form>
            
               <div class="copyright" style="color: #6600FF; text-align: center; "> Copyright © 2021 DXC Technology</div>
            
             
     
             </div>
            
          </div>
            
    </div>
    
    
    
    
 


</body>
</html>