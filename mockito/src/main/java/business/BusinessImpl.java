package business;

import data.DataRepository;

public class BusinessImpl {

  private DataRepository dataRepository;

  public void setDataRepository(DataRepository dataRepository) {
    this.dataRepository = dataRepository;
  }

  public int calculateSum(int[] numbers) {
    int sum = 0;

    for (int number : numbers) {
      sum += number;
    }

    return sum;
  }

  public int calculateSumUsingDataReposiroty() {
    int sum = 0;
    int[] numbers = dataRepository.getAllNumbersData();

    for (int number : numbers) {
      sum += number;
    }

    return sum;
  }
}
