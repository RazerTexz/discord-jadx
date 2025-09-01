package b.a.y.q0;

import com.discord.utilities.file.DownloadUtils;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: StickerView.kt */
/* renamed from: b.a.y.q0.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class StickerView2<T1, T2, R> implements Func2<DownloadUtils.DownloadState, Integer, Tuples2<? extends DownloadUtils.DownloadState, ? extends Integer>> {
    public static final StickerView2 j = new StickerView2();

    @Override // rx.functions.Func2
    public Tuples2<? extends DownloadUtils.DownloadState, ? extends Integer> call(DownloadUtils.DownloadState downloadState, Integer num) {
        return new Tuples2<>(downloadState, num);
    }
}
