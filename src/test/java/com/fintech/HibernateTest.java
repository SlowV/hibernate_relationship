package com.fintech;

import com.fintech.util.HibernateUtil;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HibernateTest {
    @Test
    public void itShouldGetSessionNotNull() {
       assertThat(HibernateUtil.getSession()).isNotNull();
    }
}
