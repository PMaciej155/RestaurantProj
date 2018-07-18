function check_uncheck_checkbox(isChecked) {
	if(isChecked) {
		$('input[name="order"]').each(function() {
			this.checked = true;
		});
	} else {
		$('input[name="order"]').each(function() {
			this.checked = false;
		});
	}
}

$(document).ready(function() {

  $('table').on('click', '.btndel', function() {
    $.ajax({
      url: '/order/' + this.id+'/delete',
      method: 'DELETE',
      success: function(result) {}
    });
    $(this).parents('tr').remove();
  });

  $('table').on('click', '.btnmod', function() {
    var status = $(this).closest("tr").find('select option:selected').val(); 
    $.ajax({
      url: '/order/' + this.id+'?status='+status,
      method: 'PUT',
      success: function(result) {}
    });
  });


})
