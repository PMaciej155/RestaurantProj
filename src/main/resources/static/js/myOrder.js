var cart = [];
var totalprice = 0;
function showOrderedMeals() {
  if (sessionStorage.getItem("cart") !== null) {
    var json_str = sessionStorage.getItem('cart');
    cart = JSON.parse(json_str);
    var table = document.getElementById("orderedMeals");

    for (var m in cart) {
      totalprice += cart[m].quantity * cart[m].price;
      var rows = "<td>" + cart[m].name + "</td><td>" + cart[m].quantity + "</td><td>" + cart[m].price + "$</td>";
      rows += '<td><input type="button" class="btn btn-dark btn-sm btndel"  onclick="deleteItem(' + m + ');" name="Delete" value="Delete"/></td>';
      var tr = document.createElement("tr");
      tr.className = "grandparent";
      tr.innerHTML = rows;
      table.appendChild(tr);
      rows = "";
    }
  }
}


function deleteItem(id) {
  cart.splice(id, 1);
  var json_str = JSON.stringify(cart);
  sessionStorage.setItem("cart", json_str);
}

function reshapeArray(arr){
  var newArr = [];

  for(var a in arr){
    var item = {};
    item.id = arr[a].id;
    item.quantity = arr[a].quantity;
    newArr.push(item);
  }
  return newArr;
}


$(document).ready(function() {

  $('table').on('click', '.btndel', function() {
    $(this).parents('tr').remove();

  });


  $("#orderForm").submit(function(event) {
    var address = new Object();
    address.firstLine = $("#firstLine").val();
    address.secondLine = $("#secondLine").val();
    address.city = $("#city").val();
    address.state = $("#state").val();
    address.zipCode = $("#zipCode").val();
    console.log(address);
    var json = {
      "address": JSON.stringify(address),
      "cart": JSON.stringify(reshapeArray(cart)),
      "totalPrice": JSON.stringify(totalprice)
    };
    $.ajax({
      url: "/myorder",
      method: "POST", //First change type to method here
      data: json,
      success: function(response) {
        cart = [];
        totalprice = 0;
        var json_str = JSON.stringify(cart);
        sessionStorage.setItem("cart", json_str);
        location.href='/myorder/success';
      }
    });
    event.preventDefault();

  });
})
