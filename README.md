# TD Reusability API

The backend service that start new analysis for the calculation of the TD Reusability Index and accesses the results. This component is a REST API implemented in Spring Boot.

<p>
Default port: 8080
</p>

## (GET) Reusability Index By Commit

### Mandatory Query Parameters

1. **url**: String
2. **sha**: String

### Optional Query Parameters

1. **limit**: Integer

### Example Request

```url
/api/reusabilityIndexByCommit?url=https://github.com/apache/commons-io&sha=b10969081c7e9a8b8529167ccfb10e6be14e9a94&limit=2
```

### Response

```json
[
   {
      "sha":"b10969081c7e9a8b8529167ccfb10e6be14e9a94",
      "revisionCount":3056,
      "filePath":"src/main/java/org/apache/commons/io/ByteOrderMark.java",
      "index":-0.0
   },
   {
      "sha":"b10969081c7e9a8b8529167ccfb10e6be14e9a94",
      "revisionCount":3056,
      "filePath":"src/main/java/org/apache/commons/io/ByteOrderParser.java",
      "index":-0.0
   }
]
```

## (GET) Reusability Index By Commit And File

### Mandatory Query Parameters

1. **url**: String
2. **filePath**: String

### Optional Query Parameters

1. limit: Integer

### Example Request

```url
/api/reusabilityIndexByCommitAndFile?url=https://github.com/apache/commons-io&sha=f5de47f2fda3bb8a3fd2daf06b431282f40e3fa8&filePath=src/main/java/org/apache/commons/io/file/DeleteOption.java
```

### Response

```json
[
   {
      "sha":"f5de47f2fda3bb8a3fd2daf06b431282f40e3fa8",
      "revisionCount":2976,
      "filePath":"src/main/java/org/apache/commons/io/file/DeleteOption.java",
      "index":-0.0
   }
]
```

## (GET) Project's Reusability Index By Commit

```url
/api/projectReusabilityIndexByCommit?url=https://github.com/apache/commons-io&sha=f5de47f2fda3bb8a3fd2daf06b431282f40e3fa8
```

### Response

```json
[
   {
      "sha":"f5de47f2fda3bb8a3fd2daf06b431282f40e3fa8",
      "revisionCount":2976,
      "index":-0.27545537643541346
   }
]
```

## (GET) Project's Reusability Index Per Commit

### Mandatory Query Parameters

1. **url**: String

### Optional Query Parameters

1. **limit**: Integer

### Example Request

```url
/api/projectReusabilityIndexPerCommit?url=https://github.com/apache/commons-io&limit=4
```

### Response

```json
[
   {
      "sha":"2e8281f0965b45853065422633841291ed996c48",
      "revisionCount":3184,
      "index":-0.2717976456285048
   },
   {
      "sha":"5111e23b01eb9e8e44361438395658d815aa0d3b",
      "revisionCount":3185,
      "index":-0.2717976456285048
   }
]
```
