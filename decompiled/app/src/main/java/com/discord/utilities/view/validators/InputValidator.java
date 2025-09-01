package com.discord.utilities.view.validators;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: InputValidator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/view/validators/InputValidator;", ExifInterface.GPS_DIRECTION_TRUE, "", "view", "", "getErrorMessage", "(Ljava/lang/Object;)Ljava/lang/CharSequence;", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface InputValidator<T> {
    CharSequence getErrorMessage(T view);
}
