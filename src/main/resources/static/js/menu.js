function addMealToCart(id, name, price) {
  var quantity = parseInt(document.getElementById("myInput" + id).value, 10);
  if (id != null || quantity != 0 || quantity != null) {
    if (sessionStorage.getItem('cart') === null) {
      var cart = [];
    } else {
      var json_str = sessionStorage.getItem('cart');
      var cart = JSON.parse(json_str);
    }
    var founded = false;
    for (var m in cart) {
      if (cart[m].id == id) {
        cart[m].quantity += quantity;
        founded = true;
      }
    }
    if (!founded) {
      var meal = {};
      meal.id = id;
      meal.name = name;
      meal.price = price;
      meal.quantity = quantity;
      cart.push(meal);
    }
    var json_str = JSON.stringify(cart);
    sessionStorage.setItem("cart", json_str);
  }
}
