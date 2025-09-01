package com.discord.utilities.stickers;

import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* compiled from: StickerUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.stickers.StickerUtils$DEFAULT_STICKER_SIZE_PX$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StickerUtils2 extends Lambda implements Function0<Integer> {
    public static final StickerUtils2 INSTANCE = new StickerUtils2();

    public StickerUtils2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return DimenUtils.dpToPixels(Opcodes.IF_ICMPNE);
    }
}
