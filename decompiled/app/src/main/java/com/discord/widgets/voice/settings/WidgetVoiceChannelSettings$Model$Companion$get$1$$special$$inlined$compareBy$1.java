package com.discord.widgets.voice.settings;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelVoiceRegion;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: Comparisons.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "K", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$Model$Companion$get$1$$special$$inlined$compareBy$1<T> implements Comparator {
    public final /* synthetic */ Comparator $comparator;

    public WidgetVoiceChannelSettings$Model$Companion$get$1$$special$$inlined$compareBy$1(Comparator comparator) {
        this.$comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return this.$comparator.compare(((ModelVoiceRegion) t).getName(), ((ModelVoiceRegion) t2).getName());
    }
}
