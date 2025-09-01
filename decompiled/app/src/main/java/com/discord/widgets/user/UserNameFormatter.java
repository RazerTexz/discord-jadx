package com.discord.widgets.user;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.AttrRes;
import androidx.annotation.IntegerRes;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.user.UserUtils;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: UserNameFormatter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ac\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/models/user/User;", "user", "", "nickname", "Landroid/content/Context;", "context", "", "primaryColorRes", "primaryFont", "primaryTextSizeSp", "secondaryColorRes", "secondaryFont", "secondaryTextSizeSp", "Landroid/text/SpannableStringBuilder;", "getSpannableForUserNameWithDiscrim", "(Lcom/discord/models/user/User;Ljava/lang/String;Landroid/content/Context;IIIIII)Landroid/text/SpannableStringBuilder;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.UserNameFormatterKt, reason: use source file name */
/* loaded from: classes.dex */
public final class UserNameFormatter {
    public static final SpannableStringBuilder getSpannableForUserNameWithDiscrim(User user, String str, Context context, @AttrRes int i, @AttrRes int i2, @IntegerRes int i3, @AttrRes int i4, @AttrRes int i5, @IntegerRes int i6) {
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(context, "context");
        Typeface themedFont = FontUtils.INSTANCE.getThemedFont(context, i2);
        List listListOf = Collections2.listOf(new ForegroundColorSpan(ColorCompat.getThemedColor(context, i)), themedFont != null ? new TypefaceSpanCompat(themedFont) : null, new AbsoluteSizeSpan(context.getResources().getInteger(i3), true));
        if (str != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), 0, str.length(), 33);
            }
            return spannableStringBuilder;
        }
        CharSequence userNameWithDiscriminator$default = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(userNameWithDiscriminator$default);
        Iterator it2 = listListOf.iterator();
        while (it2.hasNext()) {
            spannableStringBuilder2.setSpan(it2.next(), 0, user.getUsername().length(), 33);
        }
        Typeface themedFont2 = FontUtils.INSTANCE.getThemedFont(context, i5);
        Iterator it3 = Collections2.listOf(new ForegroundColorSpan(ColorCompat.getThemedColor(context, i4)), themedFont2 != null ? new TypefaceSpanCompat(themedFont2) : null, new AbsoluteSizeSpan(context.getResources().getInteger(i6), true)).iterator();
        while (it3.hasNext()) {
            spannableStringBuilder2.setSpan(it3.next(), user.getUsername().length(), userNameWithDiscriminator$default.length(), 33);
        }
        return spannableStringBuilder2;
    }
}
