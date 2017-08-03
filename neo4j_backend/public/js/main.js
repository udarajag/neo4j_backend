$(document).ready(function(){
	initialize();
});


/* AJAX send function */
function sendAjax(method, url, data, success, error){
	$.ajax({
		  method: method,
		  url: url,
		  data: data,
		  success: success,
		  error: error
		});
}

function initialize(){
	sendAjax("GET", "/loadData", null, initializeLoad, null);
}


function initializeLoad(data){
	var cy = cytoscape({

		  container: $('#cy'), // container to render in

		  elements: [ // list of graph elements to start with
		              data
		  ],

		  style: [ // the stylesheet for the graph
		    {
		      selector: 'node',
		      style: {
		        'background-color': '#666',
		        'label': 'data(id)'
		      }
		    },

		    {
		      selector: 'edge',
		      style: {
		        'width': 3,
		        'line-color': '#ccc',
		        'target-arrow-color': '#ccc',
		        'target-arrow-shape': 'triangle'
		      }
		    }
		  ],

		  layout: {
		    name: 'grid',
		    rows: 1
		  }

		});
	
	for (var i = 0; i < 10; i++) {
	    cy.add({
	        data: { id: 'node' + i }
	        }
	    );
	    var source = 'node' + i;
	    cy.add({
	        data: {
	            id: 'edge' + i,
	            source: source,
	            target: (i % 2 == 0 ? 'a' : 'b')
	        }
	    });
	}
}