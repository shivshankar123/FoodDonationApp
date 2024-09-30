package Data.Impl;

import Data.Interface.RecipientInterface;
import Data.models.Recipient;

import java.util.ArrayList;
import java.util.List;

public class RecipientImpl implements RecipientInterface {
    private List<Recipient> recipients = new ArrayList<>();

    @Override
    public void registerRecipient(Recipient recipient) {
        recipients.add(recipient);
        System.out.println("Recipient registered successfully.");
    }
}
