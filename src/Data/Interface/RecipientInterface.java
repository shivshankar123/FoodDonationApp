package Data.Interface;

import Data.models.Recipient;

import java.util.List;

public interface RecipientInterface {
    void registerRecipient(Recipient recipient);

    List<Recipient> getAllRecipients();  // New method to fetch all recipients
}
