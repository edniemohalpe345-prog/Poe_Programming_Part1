
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe.part3_poe_finale;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */

class StoredMessagesTest {

    @Test
    void loadsExistingMessages() throws IOException {

        StoredMessages stored =
                new StoredMessages(Path.of("messages.json"));

        assertNotNull(stored.getMessageIDs());
        assertTrue(stored.getMessageIDs().length > 0);

        System.out.println("\n========== STORED MESSAGES TEST ==========");
        System.out.println("Total messages: "
                + stored.getMessageIDs().length);
        System.out.println("Messages loaded successfully!");
    }

    @Test
    void displaysSentMessages() throws IOException {

        StoredMessages stored =
                new StoredMessages(Path.of("messages.json"));

        System.out.println("\n========== SENT MESSAGES ==========");

        for (String message : stored.getSentMessages()) {
            System.out.println("Sent Message: " + message);
        }
    }

    @Test
    void displaysDisregardedMessages() throws IOException {

        StoredMessages stored =
                new StoredMessages(Path.of("messages.json"));

        System.out.println("\n========== DISREGARDED MESSAGES ==========");

        for (String message : stored.getDisregardedMessages()) {
            System.out.println("Disregarded Message: " + message);
        }
    }

    @Test
    void displaysStoredMessages() throws IOException {

        StoredMessages stored =
                new StoredMessages(Path.of("messages.json"));

        System.out.println("\n========== STORED MESSAGES ==========");

        for (String message : stored.getStoredMessages()) {
            System.out.println("Stored Message: " + message);
        }
    }

    @Test
    void checksMessageDetails() throws IOException {

        StoredMessages stored =
                new StoredMessages(Path.of("messages.json"));

        System.out.println("\n========== MESSAGE DETAILS ==========");

        for (int i = 0; i < stored.getMessageIDs().length; i++) {

            System.out.println("\nMessage Number: " + (i + 1));

            System.out.println("Message ID: "
                    + stored.getMessageIDs()[i]);

            System.out.println("Message Hash: "
                    + stored.getMessageHashes()[i]);

            System.out.println("Sender: "
                    + stored.getSenders()[i]);

            System.out.println("Recipient: "
                    + stored.getRecipients()[i]);

            System.out.println("Status: "
                    + stored.getStatuses()[i]);

            System.out.println("Message Details: "
                    + stored.searchByMessageID(
                            stored.getMessageIDs()[i]));

            System.out.println("-----------------------------------");
        }
    }

    @Test
    void checksLongestMessage() throws IOException {

        StoredMessages stored =
                new StoredMessages(Path.of("messages.json"));

        String longest = stored.getLongestMessage();

        assertNotNull(longest);

        System.out.println("\n========== LONGEST MESSAGE ==========");
        System.out.println("Longest Message: " + longest);
    }

    @Test
    void displaysCompleteMessageReport() throws IOException {

        StoredMessages stored =
                new StoredMessages(Path.of("messages.json"));

        String report = stored.createMessageReport();

        assertNotNull(report);

        System.out.println("\n========== COMPLETE MESSAGE REPORT ==========");
        System.out.println(report);
    }
}
