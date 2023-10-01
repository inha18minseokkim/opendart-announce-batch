package com.example.opendartannouncereceivebatch.Reader;

import com.example.opendartannouncereceivebatch.Step.DefaultAnnouncementApiReceiveStepConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(args = {"--beginDate=20230818","--endDate=20230818"})
@MockBean(classes = {DefaultAnnouncementApiReceiveStepConfig.class})
class AnnounceDefaultReaderTest {

    @Test
    public void defaultReaderTest() {

    }

}