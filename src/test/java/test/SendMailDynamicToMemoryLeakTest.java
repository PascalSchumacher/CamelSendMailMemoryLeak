package test;

import java.util.UUID;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SendMailDynamicToMemoryLeakTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                from("scheduler:start?delay=1")
                    .setBody(constant("Hello"))
                    .setHeader("smtpFrom", method(UUID.class, "randomUUID"))
                    .recipientList(simple("smtp://localhost:1234?to=test@test.com&mail.smtp.from=${header.smtpFrom}")).cacheSize(-1).end();
//                    .toD("smtp://localhost:1234?to=test@test.com&mail.smtp.from=${header.smtpFrom}");
            }
        };
    }

    @Test
    public void test() throws Exception {
        Thread.sleep(100_000_000L);
    }
}
