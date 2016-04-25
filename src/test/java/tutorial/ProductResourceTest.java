package tutorial;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --

//        c.getConfiguration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testGetSingleProduct() {
        Product responseMsg = target.path("product/Chai").request().get(Product.class);
        assertNotNull(responseMsg);
        assertEquals("Chai", responseMsg.getProductName());
        assertEquals(1, responseMsg.getProductId());
        assertEquals(1, responseMsg.getSupplierId());
    }


    @Test
    public void testGetallProducts() {
        List<Product> products = target.path("product").request().get(List.class);
        assertEquals(77, products.size());
    }
}
