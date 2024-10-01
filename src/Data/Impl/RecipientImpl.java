package Data.Impl;

import Data.Interface.RecipientInterface;
import Data.models.Recipient;

import java.util.ArrayList;
import java.util.List;

public class RecipientImpl implements RecipientInterface {

    private List<Recipient> recipientList = new ArrayList<>();

    @Override
    public void registerRecipient(Recipient recipient) {
        recipientList.add(recipient);
        System.out.println("Recipient registered successfully.");
    }

    @Override
    public List<Recipient> getAllRecipients() {
        return recipientList;
    }
}
