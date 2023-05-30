package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String COMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getFruitFromCsvRow(List<String> dataList) {
        return dataList.stream()
                .map(line -> line.split(COMA))
                //.filter(array -> array.length == 3)
                .map(array -> new FruitTransaction(
                        FruitTransaction.Operation.getByCode(array[OPERATION_INDEX]),
                        array[FRUIT_NAME_INDEX],
                        Integer.parseInt(array[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}