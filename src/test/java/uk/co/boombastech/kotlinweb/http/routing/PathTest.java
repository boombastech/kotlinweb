package uk.co.boombastech.kotlinweb.http.routing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.boombastech.kotlinweb.http.requests.Request;
import uk.co.boombastech.kotlinweb.http.requests.Url;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PathTest {

    private Path path;
    @Mock
    private Request request;

    @Test
    public void pathMatchesWhenNoPathParameters() throws Exception {
        path = new Path("/some/url");
        when(request.getUrl()).thenReturn(new Url("http://localhost:3456/some/url"));

        assertThat(path.matches(request)).isTrue();
    }

    @Test
    public void pathDoesNotMatchWhenIncorrectNumberOfPathSegments() {
        path = new Path("/some/url");
        when(request.getUrl()).thenReturn(new Url("http://localhost:3456/some/invalid/url"));

        assertThat(path.matches(request)).isFalse();
    }
}