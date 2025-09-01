package com.discord.api.science;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Science.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB!\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/discord/api/science/Science;", "", "", "Lcom/discord/api/science/Science$Event;", "events", "Ljava/util/List;", "", "token", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Event", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class Science {
    private final List<Event> events;
    private final String token;

    /* compiled from: Science.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/api/science/Science$Event;", "", "", "a", "()Ljava/lang/String;", "type", "<init>", "()V", "MapObject", "SchemaObject", "Lcom/discord/api/science/Science$Event$MapObject;", "Lcom/discord/api/science/Science$Event$SchemaObject;", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: Science.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R%\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/api/science/Science$Event$MapObject;", "Lcom/discord/api/science/Science$Event;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "Ljava/lang/String;", "a", "", "properties", "Ljava/util/Map;", "getProperties", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class MapObject extends Event {
            private final Map<String, Object> properties;
            private final String type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MapObject(String str, Map<String, ? extends Object> map) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "type");
                Intrinsics3.checkNotNullParameter(map, "properties");
                this.type = str;
                this.properties = map;
            }

            @Override // com.discord.api.science.Science.Event
            /* renamed from: a, reason: from getter */
            public String getType() {
                return this.type;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MapObject)) {
                    return false;
                }
                MapObject mapObject = (MapObject) other;
                return Intrinsics3.areEqual(this.type, mapObject.type) && Intrinsics3.areEqual(this.properties, mapObject.properties);
            }

            public int hashCode() {
                String str = this.type;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                Map<String, Object> map = this.properties;
                return iHashCode + (map != null ? map.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("MapObject(type=");
                sbU.append(this.type);
                sbU.append(", properties=");
                return outline.M(sbU, this.properties, ")");
            }
        }

        /* compiled from: Science.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/api/science/Science$Event$SchemaObject;", "Lcom/discord/api/science/Science$Event;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "Ljava/lang/String;", "a", "Lcom/discord/api/science/AnalyticsSchema;", "schema", "Lcom/discord/api/science/AnalyticsSchema;", "b", "()Lcom/discord/api/science/AnalyticsSchema;", "<init>", "(Lcom/discord/api/science/AnalyticsSchema;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SchemaObject extends Event {
            private final AnalyticsSchema schema;
            private final String type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SchemaObject(AnalyticsSchema analyticsSchema) {
                super(null);
                Intrinsics3.checkNotNullParameter(analyticsSchema, "schema");
                this.schema = analyticsSchema;
                this.type = analyticsSchema.getAnalyticsSchemaTypeName();
            }

            @Override // com.discord.api.science.Science.Event
            /* renamed from: a, reason: from getter */
            public String getType() {
                return this.type;
            }

            /* renamed from: b, reason: from getter */
            public final AnalyticsSchema getSchema() {
                return this.schema;
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SchemaObject) && Intrinsics3.areEqual(this.schema, ((SchemaObject) other).schema);
                }
                return true;
            }

            public int hashCode() {
                AnalyticsSchema analyticsSchema = this.schema;
                if (analyticsSchema != null) {
                    return analyticsSchema.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SchemaObject(schema=");
                sbU.append(this.schema);
                sbU.append(")");
                return sbU.toString();
            }
        }

        public Event() {
        }

        /* renamed from: a */
        public abstract String getType();

        public Event(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Science(String str, List<? extends Event> list) {
        this.token = str;
        this.events = list;
    }
}
