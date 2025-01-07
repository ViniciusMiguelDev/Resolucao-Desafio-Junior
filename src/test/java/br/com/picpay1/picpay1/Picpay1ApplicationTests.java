package br.com.picpay1.picpay1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.picpay1.picpay1.entity.Todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class Picpay1ApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo = new Todo("todo 1", "desc todo 1", false, 5);
		webTestClient.post().uri("/todos").bodyValue(todo).exchange()
				.expectStatus().isOk().expectBody().jsonPath("$")
				.isArray().jsonPath("$.length()").isEqualTo(4);
	}

	@Test
	void testCreateTodoFailure() {
		var todo = new Todo("", "", false, 0);
		webTestClient.post().uri("/todos").bodyValue(todo).exchange()
				.expectStatus().isBadRequest();
	}

	@Test
	void testReadTodoSuccess() {
	}

	@Test
	void testReadTodoFailure() {
	}

	@Test
	void testUpdateTodoSuccess() {
	}

	@Test
	void testUpdateTodoFailure() {
	}

	@Test
	void testDeleteTodoSuccess() {
	}

	@Test
	void testDeleteTodoFailure() {
	}

}
