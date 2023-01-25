public class Goods {
    // Место деятельности код
    private final String md;
    private final String gtin;
    // серия
    private final String batch;
    // срок годности
    private final String exp_date;
    // MHH (СТАНДАРТИЗОВАННОЕ ЗНАЧЕНИЕ)
    private final String prod_name;
    // Торговое наименование
    private final String prod_sell_name;
    // количество на балансе
    private final int cnt;
    // количество отгруженого товара
    private final int shipped;
    // дата актуальности
    private final String updateDate;

    public Goods(String md, String gtin, String batch, String exp_date, String prod_name, String prod_sell_name, int cnt, int shipped, String updateDate) {
        this.md = md;
        this.gtin = gtin;
        this.batch = batch;
        this.exp_date = exp_date;
        this.prod_name = prod_name;
        this.prod_sell_name = prod_sell_name;
        this.cnt = cnt;
        this.shipped = shipped;
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Товар {" +
                "Адрес МД ='" + md + '\'' +
                ", gtin ='" + gtin + '\'' +
                ", Серия ='" + batch + '\'' +
                ", Срок годности ='" + exp_date + '\'' +
                ", МНН ='" + prod_name + '\'' +
                ", Торговое найменование ='" + prod_sell_name + '\'' +
                ", Количество =" + cnt +
                ", Отгружено =" + shipped +
                ", Дата актуальности ='" + updateDate + '\'' +
                '}';
    }
}
