package com.discord.widgets.voice.sheet;

import android.graphics.Bitmap;
import com.discord.utilities.colors.RepresentativeColors2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: CallParticipantsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/graphics/Bitmap;", "bitmap", "", "url", "", "invoke", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderUser$onConfigure$1 extends Lambda implements Function2<Bitmap, String, Unit> {
    public final /* synthetic */ String $colorId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter$ViewHolderUser$onConfigure$1(String str) {
        super(2);
        this.$colorId = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, String str) {
        invoke2(bitmap, str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bitmap bitmap, String str) {
        Intrinsics3.checkNotNullParameter(bitmap, "bitmap");
        RepresentativeColors2.getUserRepresentativeColors().handleBitmap(this.$colorId, bitmap, str);
    }
}
