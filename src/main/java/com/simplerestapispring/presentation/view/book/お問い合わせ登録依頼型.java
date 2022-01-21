package com.simplerestapispring.presentation.view.book;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record お問い合わせ登録依頼型(
        @NotNull Optional<String> 会社名,
        @NotEmpty String メールアドレス,
        String 担当者名,
        String 内容) {
}
