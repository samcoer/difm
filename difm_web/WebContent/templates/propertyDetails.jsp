<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Broker Net Property Entry</title>
</head>
<body>
 
<h2>Property Entry</h2>
 
<form:form method="post" action="/addproperty.htm" modelAttribute="propertyDetails">
 
<table>
    <tr>
        <td><form:label path="bhk">BHK</form:label></td>
        <td><form:input path="bhk" /></td> 
    </tr>
    <tr>
        <td><form:label path="houseNo">House/Flat No.</form:label></td>
        <td><form:input path="houseNo" /></td>
    </tr>
    <tr>
        <td><form:label path="floor">Floor No.</form:label></td>
        <td><form:input path="floor" /></td>
    </tr>
    <tr>
        <td><form:label path="address">Address</form:label></td>
        <td><form:input path="address" /></td>
    </tr>
    <tr>
        <td><form:label path="locality">Locality</form:label></td>
        <td><form:input path="locality" /></td>
    </tr>
    <tr>
        <td><form:label path="city">City</form:label></td>
        <td><form:input path="city" /></td>
    </tr>
    <tr>
        <td><form:label path="rent">Rent</form:label></td>
        <td><form:input path="rent" /></td>
    </tr>
    <tr>
        <td><form:label path="deposit">Deposit</form:label></td>
        <td><form:input path="deposit" /></td>
    </tr>
    <tr>
        <td><form:label path="availableFrom">Available From</form:label></td>
        <td><form:input path="availableFrom" /></td>
    </tr>
    <tr>
        <td><form:label path="available">Available (Y/N)</form:label></td>
        <td> <form:select path="available" size="1">
        		<form:option label="" value="" />
        		<form:option label="Yes" value="true" />
        		<form:option label="No" value="false" />
             </form:select> 
        </td>
    </tr>
    <tr>
        <td><form:label path="type">Type (Individual/Apartment)</form:label></td>
        <td><form:input path="type" /></td>
    </tr>
    <tr>
        <td><form:label path="furnished">Furnishing (Fully Furnished/Semi Furnished/Un Furnished)</form:label></td>
        <td><form:input path="furnished" /></td>
    </tr>
    <tr>
        <td><form:label path="owner">Owner Name</form:label></td>
        <td><form:input path="owner" /></td>
    </tr>
    <tr>
        <td><form:label path="ownerPhone">Owner Phone</form:label></td>
        <td><form:input path="ownerPhone" /></td>
    </tr>
    <tr>
        <td><form:label path="ownerPan">Owner PAN</form:label></td>
        <td><form:input path="ownerPan" /></td>
    </tr>
    <tr>
        <td><form:label path="blocked">Blocked (Y/N)</form:label></td>
        <!-- <td> <form:select path="blocked" size="1">
        		<form:option label="" value="" />
        		<form:option label="Yes" value="true" />
        		<form:option label="No" value="false" />
             </form:select> 
        </td>-->
        <td>
        	<spring:bind path="blocked">
        	<select id="blocked" name="blocked">
        	<option value=""> </option>
        	<option value="true">Yes</option>
        	<option value="false">No</option>
            </select>
            </spring:bind>
        </td>
    </tr>
    <tr>
        <td><form:label path="favorite">Favourite (Y/N)</form:label></td>
        <td> <form:select path="favorite" size="1">
        		<form:option label="" value="" />
        		<form:option label="Yes" value="true" />
        		<form:option label="No" value="false" />
             </form:select> 
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add"/>
        </td>
    </tr>
</table>  
</form:form>
 
</body>
</html>