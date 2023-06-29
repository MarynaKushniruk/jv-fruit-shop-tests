package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FilesParser;
import java.util.ArrayList;
import java.util.List;

public class FilesParserImpl implements FilesParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseFruitTransaction(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] parsedData = data.get(i).split(SEPARATOR);

            FruitTransaction.Operation operationName =
                    FruitTransaction.Operation
                    .getByCode(FruitTransaction.Operation.class, parsedData[OPERATION_TYPE_INDEX]);
            String fruitName = parsedData[FRUIT_NAME_INDEX];
            int quantityOfFruit = Integer.parseInt(parsedData[FRUIT_QUANTITY_INDEX]);
            FruitTransaction fruitTransaction =
                    new FruitTransaction(operationName, fruitName, quantityOfFruit);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}