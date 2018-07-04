package kr.co.florier.florier_mock_up.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by LJY on 2018-05-24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_flower {
    private String name;
    private String price;
    private String count;
}
