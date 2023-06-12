package hello.springmvc.basic.requestMapping;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/hello-basic", "/hello-go"}, method = RequestMethod.GET)
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping("/mapping-get")
    public String mappingGet() {
        log.info("mapping-get");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath data={}", data);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath2(@PathVariable String userId,
                               @PathVariable String orderId) {
        log.info("mappingPath2 userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    //params가 uri에 없으면 호출 안함

    /**
     * 잘 사용안함
     * params가 uri에 없으면 호출 안함
     * 파라메타 추가 매핑
     * params="mode",
     * params="!mode",
     * params="mode=debug",
     * params="mode!=debug",
     * params={"mode=debug", "data=good"}
     */
    @GetMapping(value = "/mapping-param", params = {"mode=debug", "data=good"})
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode",
     * headers="mode=debug",
     * headers="mode!=debug",
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type 매핑
     * consumes="application/json",
     * consumes="!application/json",
     * consumes="application/*",
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces="text/html",
     * produces="!text/html",
     * produces="text/*",
     * produces="*\/*",
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
