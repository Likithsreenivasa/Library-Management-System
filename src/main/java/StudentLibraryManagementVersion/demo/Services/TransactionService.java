package StudentLibraryManagementVersion.demo.Services;

import StudentLibraryManagementVersion.demo.DTOs.IssueBookRequestDto;
import StudentLibraryManagementVersion.demo.Enums.CardStatus;
import StudentLibraryManagementVersion.demo.Enums.TransactionStatus;
import StudentLibraryManagementVersion.demo.Models.Book;
import StudentLibraryManagementVersion.demo.Models.Card;
import StudentLibraryManagementVersion.demo.Models.Transactions;
import StudentLibraryManagementVersion.demo.Repositories.BookRepository;
import StudentLibraryManagementVersion.demo.Repositories.CardRepository;
import StudentLibraryManagementVersion.demo.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {
        int bookId = issueBookRequestDto.getBookId();
        int cardId = issueBookRequestDto.getCardId();

        // Get the Book Entity and card Entity ?? Why do need this.
        // We are doing this set transaction attributes.

        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();

        // Final goal is to make transaction Entity,set attributes.
        // and save it

        Transactions transaction = new Transactions();

        //Setting attributes
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIssueOperations(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);


        if(book == null || book.isIssued()== true)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not Available");
        }

        if(card == null || card.getCardStatus() != CardStatus.ACTIVATE)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);

            throw new Exception("Card is not Valid");

        }


        // Do validations

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);




        // foreign key
        book.setIssued(true);

        List<Transactions>  listOfTransactionForBook = book.getListOfTransactions();
        listOfTransactionForBook.add(transaction);
        ((Book) book).setListOfTransactions(listOfTransactionForBook);

        List<Book> issuedBookForCard = ((Card) card).getBooksIssued();
        issuedBookForCard.add(book);
        card.setBooksIssued(issuedBookForCard);

        List<Transactions> transactionsListForCard = card.getTransactions();
        transactionsListForCard.add(transaction);
        card.setTransactions(transactionsListForCard);

        cardRepository.save(card);

        return "Book issued successfully";
    }
    public String getTransactions(int bookId,int cardId)
    {
        List<Transactions> transactionsList = transactionRepository.getTransactionsForBookAndCard(bookId, cardId);

        String transactionId = transactionsList.get(0).getTransactionId();

        return transactionId;
    }

}
