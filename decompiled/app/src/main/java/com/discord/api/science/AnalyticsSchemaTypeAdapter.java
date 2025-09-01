package com.discord.api.science;

import b.i.d.FieldNamingPolicy;
import b.i.d.GsonBuilder;
import b.i.d.JsonSerializationContext;
import b.i.d.JsonSerializer2;
import b.i.d.q.x.JsonTreeWriter;
import com.discord.api.science.Science;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: AnalyticsSchemaTypeAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00070\u0006*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/api/science/AnalyticsSchemaTypeAdapter;", "Lb/i/d/m;", "Lcom/discord/api/science/Science$Event$SchemaObject;", "", "", "", "", "Lkotlin/Pair;", "a", "(Ljava/util/Map;)Ljava/util/List;", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AnalyticsSchemaTypeAdapter implements JsonSerializer2<Science.Event.SchemaObject> {
    private final Gson gson;

    public AnalyticsSchemaTypeAdapter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.c = FieldNamingPolicy.m;
        this.gson = gsonBuilder.a();
    }

    public final List<Tuples2<String, Object>> a(Map<String, ? extends Object> map) {
        List<Tuples2<String, Object>> listListOf;
        Intrinsics3.checkNotNullParameter(map, "$this$flatMapProperties");
        Set<Map.Entry<String, ? extends Object>> setEntrySet = map.entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            if (!(value instanceof Map)) {
                value = null;
            }
            Map<String, ? extends Object> map2 = (Map) value;
            if (map2 == null || (listListOf = a(map2)) == null) {
                listListOf = CollectionsJVM.listOf(new Tuples2(entry.getKey(), entry.getValue()));
            }
            MutableCollections.addAll(arrayList, listListOf);
        }
        return arrayList;
    }

    @Override // b.i.d.JsonSerializer2
    public JsonElement serialize(Science.Event.SchemaObject schemaObject, Type type, JsonSerializationContext jsonSerializationContext) throws JsonSyntaxException, JsonIOException {
        Science.Event.SchemaObject schemaObject2 = schemaObject;
        Intrinsics3.checkNotNullParameter(schemaObject2, "src");
        Intrinsics3.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics3.checkNotNullParameter(jsonSerializationContext, "context");
        Gson gson = this.gson;
        String type2 = schemaObject2.getType();
        AnalyticsSchema schema = schemaObject2.getSchema();
        Intrinsics3.checkNotNullParameter(schema, "$this$serializeToMap");
        Object objG = this.gson.g(this.gson.m(schema), new AnalyticsSchemaTypeAdapter2().getType());
        Intrinsics3.checkNotNullExpressionValue(objG, "gson.fromJson(json, obje…<String, Any>>() {}.type)");
        Science.Event.MapObject mapObject = new Science.Event.MapObject(type2, Maps6.toMap(a((Map) objG)));
        Objects.requireNonNull(gson);
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        gson.o(mapObject, Science.Event.MapObject.class, jsonTreeWriter);
        JsonElement jsonElementL = jsonTreeWriter.L();
        Intrinsics3.checkNotNullExpressionValue(jsonElementL, "gson.toJsonTree(\n       …).toMap()\n        )\n    )");
        return jsonElementL;
    }
}
