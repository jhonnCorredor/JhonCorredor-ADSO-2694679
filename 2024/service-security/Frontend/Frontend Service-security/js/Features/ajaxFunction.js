// ajaxFunctions.js
$(document).ready(function() {
    const genderSelect = $('#address');
  
    $.ajax({
      url: 'http://localhost:9000/service-security/v1/api/person/direction',
      type: 'GET',
      dataType: 'json',
      success: function(data) {
        $.each(data, function(index, option) {
          const optionElement = $('<option></option>').attr('value', option).text(option);
          genderSelect.append(optionElement);
        });
      },
      error: function(jqXHR, textStatus, errorThrown) {
        console.error('Error al obtener datos desde el endpoint:', errorThrown);
      }
    });
  });