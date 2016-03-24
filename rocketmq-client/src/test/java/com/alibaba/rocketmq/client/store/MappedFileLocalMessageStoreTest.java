package com.alibaba.rocketmq.client.store;

import com.alibaba.rocketmq.common.message.Message;
import org.junit.Test;

public class MappedFileLocalMessageStoreTest {

    @Test
    public void testStash() throws Exception {
        MappedFileLocalMessageStore store = new MappedFileLocalMessageStore("/Users/macbookpro/localMessageStoreTest");
        store.start();

        Message message = new Message("Test", "Test123".getBytes());
        store.stash(message);

        Message[] messages = store.pop(10);
        for (Message msg : messages) {
            System.out.println(msg);
            System.out.println(new String(msg.getBody(), "UTF-8"));
        }

        store.close();

    }
}