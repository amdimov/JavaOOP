package P05Telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder browser = new StringBuilder();
        for (String url : urls) {
            if (url.matches("^.*\\d.*$")){
                browser.append("Invalid URL!").append(System.lineSeparator());
            }else {
                browser.append("Browsing: ").append(url)
                        .append("!").append(System.lineSeparator());
            }
        }
        browser.setLength(browser.length()-1);
        return browser.toString();
    }

    @Override
    public String call() {
        StringBuilder calling = new StringBuilder();
        for (String number : numbers) {
            if (number.matches("^.*[a-zA-Z].*$")){
                calling.append("Invalid number!").append(System.lineSeparator());
            }else {
                calling.append("Calling... ").append(number)
                        .append(System.lineSeparator());
            }
        }
        calling.setLength(calling.length()-1);
        return calling.toString();
    }
}
