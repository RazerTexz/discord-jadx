package com.discord.widgets.botuikit.views;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.botuikit.Component6;
import com.discord.models.botuikit.MessageComponent;
import com.discord.widgets.botuikit.ComponentProvider;
import kotlin.Metadata;

/* compiled from: ComponentView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/botuikit/views/ComponentView;", "Lcom/discord/models/botuikit/MessageComponent;", ExifInterface.GPS_DIRECTION_TRUE, "", "component", "Lcom/discord/widgets/botuikit/ComponentProvider;", "componentProvider", "Lcom/discord/widgets/botuikit/views/ComponentActionListener;", "componentActionListener", "", "configure", "(Lcom/discord/models/botuikit/MessageComponent;Lcom/discord/widgets/botuikit/ComponentProvider;Lcom/discord/widgets/botuikit/views/ComponentActionListener;)V", "Lcom/discord/api/botuikit/ComponentType;", "type", "()Lcom/discord/api/botuikit/ComponentType;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface ComponentView<T extends MessageComponent> {
    void configure(T component, ComponentProvider componentProvider, ComponentView2 componentActionListener);

    Component6 type();
}
